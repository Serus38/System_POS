package com.system.system_pos.model.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 20)
    private String nit;

    @NotBlank
    @Email
    @Column(nullable = false, length = 50)
    private String email;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, length = 100)
    private String address;

    public Supplier(Long id, @NotBlank String name, String nit, @NotBlank @Email String email, @NotBlank String phone,
            String address) {
        this.id = id;
        this.name = name;
        this.nit = nit;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
