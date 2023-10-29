package com.mitocode.controller;

import com.mitocode.dto.MenuDTO;
import com.mitocode.model.Menu;
import com.mitocode.service.IMenuService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IMenuService service;

    @GetMapping
    public ResponseEntity<List<MenuDTO>> getAllMenus() throws Exception{
        List<Menu> menus = service.findAll();
        List<MenuDTO> menusDTO = modelMapper.map(menus, new TypeToken<List<MenuDTO>>() {}.getType());
        return new ResponseEntity<>(menusDTO, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<MenuDTO>> getMenusByUser() throws Exception{
        List<Menu> menus = service.getMenusByUsername();
        List<MenuDTO> menusDTO = modelMapper.map(menus, new TypeToken<List<MenuDTO>>() {}.getType());
        return new ResponseEntity<>(menusDTO, HttpStatus.OK);
    }


}
