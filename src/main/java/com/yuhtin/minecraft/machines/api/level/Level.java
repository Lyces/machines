package com.yuhtin.minecraft.machines.api.level;

import lombok.Builder;
import lombok.Data;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

@Data
@Builder
public class Level {

    private final String coloredName;
    private final long millisToGenerate;
    private final double quantityToGenerate;

}
