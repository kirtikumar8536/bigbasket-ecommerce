package com.bigbasket;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.registry.AlgorithmRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;


class BigbasketApplicationTests {

    @Test
    void test(){
        Set allPBEAlgorithms = AlgorithmRegistry.getAllPBEAlgorithms();
        System.out.println("these all are the list of algorithm which we use to decrypt ");
        for (Object algorithm : allPBEAlgorithms) {
            System.out.println(algorithm);
        }
       // System.out.println("all of these are the set of algorithm"+allPBEAlgorithms);

    }
    @Test
    void contextLoads() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("javadev"); // encryptor's private key
        config.setAlgorithm("PBEWithMD5AndDES");  // algorithm for encryption
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        String plainText = "Root@123"; // enter here user name and password to get the ecrypted value
        String encryptedPassword = encryptor.encrypt(plainText);
        System.out.println("encryptedPassword : " + encryptedPassword);
    }
    //encryptedPassword : oy5JCUaVHJWL2p1pDu/8wA==
      //username : ZI1GD5N05YIBipAeuLarBw==
}
