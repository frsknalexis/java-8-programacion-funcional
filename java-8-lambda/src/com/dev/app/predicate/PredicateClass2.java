package com.dev.app.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateClass2 {

	public static void main(String[] args) {
		
		Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting(2, "linode", "linode.com");
        Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting(4, "google", "google.com");

        List<Hosting> list = Arrays.asList(new Hosting[]{h1, h2, h3, h4});

        Predicate<Hosting> startWithG = (h) -> h.getName().startsWith("g");
        
        List<Hosting> resultList = HostingRepository.filterHosting(list, startWithG);
        System.out.println(resultList);
        
        Predicate<Hosting> isDeveloperFriendly = (h) -> h.getName().equals("linode");
        
        List<Hosting> resultList2 = HostingRepository.filterHosting(list, isDeveloperFriendly);
        System.out.println(resultList2);
	}
}
