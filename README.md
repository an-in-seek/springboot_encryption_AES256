# AES Encryption and Decryption with Java Spring Boot

자바(Java) 기반 스프링 부트(Spring Boot)에서 AES256 알고리즘을 이용한 암호화/복호화 예제 코드

이 저장소에는 다양한 방법을 사용하여 AES 암호화 및 복호화를 수행하는 Java 코드 예제가 포함되어 있습니다. AES(고급 암호화 표준)는 민감한 데이터를 보호하기 위해 널리 사용되는 대칭 암호화 알고리즘입니다.

## EncryptionUtil Class

`EncryptionUtil` 클래스는 CBC(Cipher Block Chaining) 모드와 PKCS5 패딩을 사용하여 AES 암호화 및 복호화를 수행하는 메서드를 제공합니다. 암호화 및 복호화를 위해 정적 초기화 벡터(IV)와 비밀 키가 사용됩니다.

### 사용법

1. **데이터 암호화:**

    ```java
    String plainText = "Hello, World!";
    String encryptedText = EncryptionUtil.encrypt(plainText);
    System.out.println("Encrypted: " + encryptedText);
    ```

2. **데이터 복호화:**

    ```java
    String decryptedText = EncryptionUtil.decrypt(encryptedText);
    System.out.println("Decrypted: " + decryptedText);
    ```

### 중요 사항

- **보안 고려 사항:**
    - `EncryptionUtil` 클래스에서 사용되는 비밀 키(`KEY`)는 안전하게 관리되어야 합니다. 코드에 직접 하드코딩하는 것을 피하십시오.
    - 암호화에 정적 IV를 사용하는 것은 보안상 권장되지 않습니다. IV는 각 암호화 작업에 대해 무작위로 생성되어야 하며 암호문과 함께 전송되어야 합니다.
- **예외 처리:** 암호화 및 복호화 작업 시 적절한 예외 처리를 수행하십시오.
- **키 관리:** 민감한 데이터를 보호하기 위해 안전한 키 관리 방법을 구현하십시오.