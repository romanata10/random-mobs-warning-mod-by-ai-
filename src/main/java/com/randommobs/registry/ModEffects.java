package com.randommobs.registry;

import com.randommobs.RandomMobs;
import com.randommobs.effect.RootVirusEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RandomMobs.MODID);

    /** The Root Virus from Gemini Home Entertainment. Applied when a woodcrawler hits you. */
    public static final RegistryObject<MobEffect> ROOT_VIRUS = MOB_EFFECTS.register("root_virus",
            RootVirusEffect::new);
}
