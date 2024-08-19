package NingCode1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int n = Integer.parseInt(tokenizer.nextToken());
        int q = Integer.parseInt(tokenizer.nextToken());
        
        long[] a = new long[n + 1];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(tokenizer.nextToken());
        }
        
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }
        
        PrintWriter writer = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String c = tokenizer.nextToken();
            int x = Integer.parseInt(tokenizer.nextToken());
            
            if (c.equals("L")) {
                long sum = prefixSum[x % n] - prefixSum[0];
                writer.println(sum);
            } else if (c.equals("R")) {
                long sum = prefixSum[n] - prefixSum[n - (x % n) - 1];
                writer.println(sum);
            }
        }
        
        writer.flush();
      
    }

}

class ListNode{

}