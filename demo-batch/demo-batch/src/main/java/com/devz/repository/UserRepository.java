/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.devz.repository;

import com.devz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ravinath
 */
public interface UserRepository extends JpaRepository<User, Integer>{

}
