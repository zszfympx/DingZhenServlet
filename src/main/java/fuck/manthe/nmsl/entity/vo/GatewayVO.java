package fuck.manthe.nmsl.entity.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GatewayVO {
    private Long id;

    private String name;
    private String address;
}