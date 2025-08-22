package com.mnptracker.trigger.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashUtil {
  public static String sha256(String data) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] digest = md.digest(data.getBytes(StandardCharsets.UTF_8));
      StringBuilder sb = new StringBuilder();
      for (byte b : digest) sb.append(String.format("%02x", b));
      return sb.toString();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

