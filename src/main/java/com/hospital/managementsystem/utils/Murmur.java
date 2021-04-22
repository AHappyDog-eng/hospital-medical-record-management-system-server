package com.hospital.managementsystem.utils;

import com.google.common.base.Joiner;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * @author ning.wang
 * @date 2021/3/29 19:16
 */
public class Murmur {
  private static HashFunction function = Hashing.murmur3_128();
  private static Charset charset = Charset.forName("utf-8");

  public static String hash(Object ...sources) {

    String source = Joiner.on("-").join(sources);
    return function.newHasher().putString(source, charset).hash().toString();
  }
}
