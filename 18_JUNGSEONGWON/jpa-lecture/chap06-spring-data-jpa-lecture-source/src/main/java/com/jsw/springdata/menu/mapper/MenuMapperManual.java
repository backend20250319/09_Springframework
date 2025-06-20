package com.jsw.springdata.menu.mapper;


import com.jsw.springdata.menu.dto.MenuDTO;
import com.jsw.springdata.menu.entity.Menu;

// 수동 매핑 메소드
public class MenuMapperManual {
    // entity -> dto 직접 매핑
    public static MenuDTO toDTO(Menu menu) {
        MenuDTO dto = new MenuDTO();
        dto.setMenuCode(menu.getMenuCode());
        dto.setMenuName(menu.getMenuName());
        dto.setMenuPrice(menu.getMenuPrice());
        dto.setCategoryCode(menu.getCategoryCode());
        dto.setOrderableStatus(menu.getOrderableStatus());
        return dto;
    }
    // dto -> entity 직접 매핑
    public static Menu toEntity(MenuDTO dto) {

        // 생성자 패턴
//        return new Menu(dto.getMenuCode(), dto.getMenuName(), dto.getMenuPrice(), dto.getCategoryCode(), dto.getOrderableStatus());

        // 빌더 패턴
        return Menu.builder()
                .menuCode(dto.getMenuCode())
                .menuName(dto.getMenuName())
                .menuPrice(dto.getMenuPrice())
                .categoryCode(dto.getCategoryCode())
                .orderableStatus(dto.getOrderableStatus())
                .build();

    }
}
