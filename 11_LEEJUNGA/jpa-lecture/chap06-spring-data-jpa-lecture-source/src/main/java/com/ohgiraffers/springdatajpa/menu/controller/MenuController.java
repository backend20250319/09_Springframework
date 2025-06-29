package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.common.Pagenation;
import com.ohgiraffers.springdatajpa.common.PagingButton;
import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j  // log라는 변수명으로 Logger 객체 타입의 필드가 선언되고 생성된다.
public class MenuController {
    private final MenuService menuService;
    private final CategoryRepository categoryRepository;

    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable("menuCode") String menuCode, Model model) {
        MenuDTO resultMenu = menuService.findMenuByMenuCode(Integer.parseInt(menuCode));

        // 수행결과에 따라 필요한 값을 담아서 필요한 페이지로 이동
        model.addAttribute("menu", resultMenu);
        return "menu/detail"; // viewresolver라는 객체를 통해서 /resource/menu/detail.html로 이동
    }

    @GetMapping("/list")
    public String findMenuList(Model model, @PageableDefault Pageable pageable) {
        /*
         * System.out.print 계열의 메소드보다 효율적으로 로그 출력을 할 수 있다.
         * 로그 레벨에 맞춘 메소드를 통해 출력 처리한다.
         * {} 를 통해 값이 입력될 위치를 포매팅한다.
         * */
        log.info("pageable ⭐⭐⭐️ ======> {}", pageable);

        /* 1. 페이징처리안된 단순 리스트 조회 테스트 */
//        List<MenuDTO> menuList = menuService.findMenuList();
//        log.info("log menuList =====> {}", menuList);

        /* 2. 페이징 처리 */
        Page<MenuDTO> menuList = menuService.findMenuList(pageable);
        PagingButton paging = Pagenation.getPagingButtonInfo(menuList);
        log.info("log menuList =====> {}", menuList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        log.info("getContent : {}", menuList.getContent());
        log.info("getTotalPages : {}", menuList.getTotalPages());
        log.info("getTotalElements : {}", menuList.getTotalElements());
        log.info("getNumberOfElements : {}", menuList.getNumberOfElements());
        log.info("isFirst : {}", menuList.isFirst());
        log.info("isLast : {}", menuList.isLast());
        return "menu/list";
    }

    @GetMapping("/querymethod")
    public void queryMethodPage() {

    }

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam Integer menuPrice, Model model) {
        List<MenuDTO> menuList = menuService.findByMenuPrice(menuPrice);

        model.addAttribute("menuList", menuList);
        return "menu/searchResult";
    }

    @GetMapping("/regist")
    public void registPage() {

    }

    @GetMapping("/category")
    @ResponseBody // 응답 데이터 body에 반환 값을 그대로 전달하겠다는 의미(ViewResolver 사용 X)
    public List<CategoryDTO> findCategoryList() {
        return menuService.findAllCategory();
    }

    @PostMapping("/regist")
    public String registMenu(@ModelAttribute MenuDTO menuDTO) {  // input의 name값과 필드명이 동일해야된다.
        menuService.registMenu(menuDTO);
        // insert, update, delete의 행위후에 새로운 request, response를 만들기위해 redirect
        return "redirect:/";
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyMenu(@ModelAttribute MenuDTO menuDTO) {
        menuService.modifyMenu(menuDTO);
        return "redirect:/menu/" + menuDTO.getMenuCode();
    }

    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteMenu(@RequestParam Integer menuCode) {
        menuService.deleteMenu(menuCode);
        return "redirect:/menu/list";
    }
}
