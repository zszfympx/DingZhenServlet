package fuck.manthe.nmsl.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GlobalConfigDTO {
    private boolean cache;
    private boolean firstRun;
}
