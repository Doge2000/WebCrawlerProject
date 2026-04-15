package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.*;
import java.io.*;


public class Crawler {
    public static void main(String[] args){
        String starterurl = "https://en.wikipedia.org/wiki/Apollo_10";
        Document doc = getURL(starterurl);
        crawl(starterurl, "https://en.wikipedia.org/wiki/Human_spaceflight");
    }

    public static Document getURL(String url){
        try{
            Document d = Jsoup.connect(url).get();
            return d;
        }
        catch (Exception e){
            System.out.println("Failed to reach URL: "+url);
        }
        return null;
    }

    public static void crawl(String url, String targeturl){
        HashSet<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(url);
        while(!q.isEmpty()){
            String u = q.poll();
            if(!u.startsWith("http://") && !u.startsWith("https://")){
                System.out.println("Skipping invalid URL");
                continue;
            }
            if(u.equals(targeturl)){
                System.out.println("Reached Target URL: "+targeturl);
                break;
            }
            System.out.println("Visited URL: "+u);
            vis.add(u);
            Document doc = getURL(u);
            if(doc!=null) {
                Elements links = doc.select("a[href]");
                for(Element link: links){
                    String neigh = link.absUrl("href");
                    if(!neigh.isEmpty() && !vis.contains(neigh)){
                        q.offer(neigh);
                    }
                }
            }
        }
    }
}
