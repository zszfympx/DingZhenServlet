package fuck.manthe.nmsl.entity.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GatewayHeartbeatVO {
    private long time;
    private ColdDownVO coldDown;
}