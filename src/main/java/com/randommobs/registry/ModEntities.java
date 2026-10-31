package com.randommobs.registry;

import com.randommobs.RandomMobs;
import com.randommobs.entity.TripodEntity;
import com.randommobs.entity.WoodcrawlerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RandomMobs.MODID);

    /** Giant three-legged war machine. ~7.7 blocks tall. Fireproof (but not waterproof!). */
    public static final RegistryObject<EntityType<TripodEntity>> TRIPOD = ENTITY_TYPES.register("tripod",
            () -> EntityType.Builder.of(TripodEntity::new, MobCategory.MONSTER)
                    .sized(2.4F, 7.7F)
                    .clientTrackingRange(16)
                    .updateInterval(2)
                    .fireImmune()
                    .build("tripod"));

    /** Tall wooden humanoid from Gemini Home Entertainment. ~3.3 blocks tall. */
    public static final RegistryObject<EntityType<WoodcrawlerEntity>> WOODCRAWLER = ENTITY_TYPES.register("woodcrawler",
            () -> EntityType.Builder.of(WoodcrawlerEntity::new, MobCategory.MONSTER)
                    .sized(0.9F, 3.3F)
                    .clientTrackingRange(12)
                    .build("woodcrawler"));
}
