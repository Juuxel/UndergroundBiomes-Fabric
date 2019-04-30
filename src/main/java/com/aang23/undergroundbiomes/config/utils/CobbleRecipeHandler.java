package com.aang23.undergroundbiomes.config.utils;

import com.aang23.undergroundbiomes.config.UBConfig;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionSerializer;
import java.util.function.BooleanSupplier;

public class CobbleRecipeHandler implements IConditionSerializer
{
    @Override
    public BooleanSupplier parse(JsonObject json)
    {
        boolean value = JsonUtils.getBoolean(json , "value", true);
        return () -> UBConfig.RECIPES.cobbleToVanillaRecipe.get() == value;
    }

}