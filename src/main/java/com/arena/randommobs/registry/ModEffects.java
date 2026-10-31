package com.arena.randommobs.registry;

import com.arena.randommobs.RandomMobs;
import com.arena.randommobs.effect.RootInfectionEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RandomMobs.MODID);

    public static final RegistryObject<MobEffect> ROOT_INFECTION =
            EFFECTS.register("root_infection", RootInfectionEffect::new);
}
