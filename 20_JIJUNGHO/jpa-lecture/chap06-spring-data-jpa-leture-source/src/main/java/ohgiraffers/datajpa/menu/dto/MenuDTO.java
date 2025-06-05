package ohgiraffers.datajpa.menu.dto;

import lombok.*;
import ohgiraffers.datajpa.menu.entity.Menu;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDTO {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public static MenuDTO changeMenuDTO(Menu menu) {
        MenuDTO menuDTO = MenuDTO.builder()
                .menuCode(menu.getMenuCode())
                .menuName(menu.getMenuName())
                .menuPrice(menu.getMenuPrice())
                .categoryCode(menu.getCategoryCode())
                .orderableStatus(menu.getOrderableStatus())
                .build();
        return menuDTO;
    }
}
