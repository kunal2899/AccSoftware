package com.accsoftware.rest.security;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderDecoder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter string to encode: ");
		String str = s.next();
		s.close();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Encoded String : " + encoder.encode(str));
	}
}
