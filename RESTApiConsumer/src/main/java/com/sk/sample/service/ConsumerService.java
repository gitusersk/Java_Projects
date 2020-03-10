package com.sk.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sk.sample.model.CollatedResponse;
import com.sk.sample.model.Employee;
import com.sk.sample.model.EmployeeData;
import com.sk.sample.model.EmployeeDataRequest;


@Service
public class ConsumerService {
	
		
	@Value("${app.service.thirdPartyApiUrl}")
	private String url;
	
	@Value("${app.service.fetchEndPoint}")
	private String fetchEmployee;
	
	@Value("${app.service.threads}")
	private int numOfThreads;
		
	// Asynchronous call to third party api
	public CollatedResponse getEmployee(EmployeeDataRequest request) throws InterruptedException, ExecutionException { 
		
		CollatedResponse collatedResponse=new CollatedResponse();
		List<Employee> empList = new ArrayList<>();
		String apiUri=url + fetchEmployee;
		
		List<CompletableFuture<Employee>> completableFutureList = new ArrayList<>();
		ThreadPoolExecutor customExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numOfThreads);
		
		for(int i = 0; i < request.getEmpData().size(); i++) {
			
			EmployeeData employeeData=request.getEmpData().get(i);
			
			CompletableFuture<Employee>	cf= CompletableFuture.supplyAsync(() -> 
				new ServiceUtil().apiCallAsync(apiUri, employeeData),customExecutor
			);
			
			completableFutureList.add(cf);
						
		} // for loop end
		
		List<Employee> empResponseList = processCompletableFutures(completableFutureList);

		// prepare collated response to return
		collatedResponse.setRequestId(request.getRequestId());
		collatedResponse.setEmpList(empResponseList);
		return collatedResponse;
 }
	
	
	
	
	
	/////// method to collate and process all completable futures
	public List<Employee> processCompletableFutures(List<CompletableFuture<Employee>> completableFutureList) throws InterruptedException, ExecutionException{
		
	// Create a combined Future using allOf()
			CompletableFuture<Void> allFutures = CompletableFuture.allOf(
					completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])
			);
			
			// When all the Futures are completed, call `future.join()` to get their results and collect the results in a list -
			CompletableFuture<List<Employee>> allCompletableFuture = allFutures.thenApply(future -> {
			   return completableFutureList.stream()
			           .map(completableFuture -> completableFuture.join())
			           .collect(Collectors.toList());
			});
			
			
			CompletableFuture completableFuture = allCompletableFuture.thenApply(resp -> {
				   return resp.stream().collect(Collectors.toList());
				});
			
			
			List<Employee> responseList = (ArrayList<Employee>)completableFuture.get();
			
			System.out.println("completableFutureList Size: "+completableFutureList.size());
			System.out.println("responseList in processCompletableFutures: "+responseList);
			
			return responseList;
	
		
	}
	

}
