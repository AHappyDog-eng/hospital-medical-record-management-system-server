package com.hospital.managementsystem.utils;

import com.google.common.base.Joiner;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author ning.wang
 * @date 2021/3/29 19:16
 */
@Component
public class Murmur {
  private static HashFunction function = Hashing.murmur3_128();
  private static Charset charset = Charset.forName("utf-8");

  public String hash(Object... sources) {

    String source = Joiner.on("-").join(sources);
    return function.newHasher().putString(source, charset).hash().toString();
  }

  public String base64(String str) {
    byte[] bytes = str.getBytes();
    //Base64 加密
    return Base64.getEncoder().encodeToString(bytes);
  }

  public String decode(String token) {
    byte[] decoded = Base64.getDecoder().decode(token);
    return new String(decoded);
  }
}
