package com.example.test_java.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import org.jasypt.hibernate5.type.EncryptedStringType;

@Entity
@Data
@Table(name = "PERSON")
@TypeDef(name = "encryptedString",
        typeClass = EncryptedStringType.class, parameters = {
        @org.hibernate.annotations.Parameter
                (name = "encryptorRegisteredName",
                        value = "hibernateStringEncryptor") })
public class Person implements Serializable {

    @Id
    @Column(name = "ID", length = 19)
    private long id;

    @Type(type="encryptedString")
    @Column(name = "FIRSTNAME")
    private String firstName;

    @Type(type="encryptedString")
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "GENDER")
    private int gender;

    @Column(name = "TYPE")
    private int type;
}
