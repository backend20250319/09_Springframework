package com.jsw.springdata.menu.dto;


import com.jsw.springdata.menu.entity.Menu;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자 대용
@AllArgsConstructor // 메소드생성자 대용
@Builder
public class MenuDTO {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public static MenuDTO changeMenuDto(Menu menu){
        // 수동 매핑 메소드
        MenuDTO menuDto = MenuDTO.builder()
                .menuCode(menu.getMenuCode())
                .menuName(menu.getMenuName())
                .menuPrice(menu.getMenuPrice())
                .categoryCode(menu.getCategoryCode())
                .orderableStatus(menu.getOrderableStatus())
                .build();
        return menuDto;
    }
}
