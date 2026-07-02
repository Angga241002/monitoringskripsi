package com.monitoringskripsi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dosen")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dosen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nidn;

    @Column(nullable = false)
    private String nama;

    @Column(unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
