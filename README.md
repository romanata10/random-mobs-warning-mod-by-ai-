# Random Mobs (Forge 1.20.1)

A Minecraft Forge mod for **1.20.1** that adds two horror mobs and one very
fishy achievement.

![logo](src/main/resources/randommobs_logo.png)

## Mobs

### Tripod («Тринога»)
A giant three-legged war machine from *War of the Worlds*: bronze hood with
glowing lights, two hanging tentacles and a **heat ray** that sets you on fire.

- 150 HP, 12 armor, immune to fire and lava
- Heat ray: 6s of fire + heavy damage at range, melee stomps up close
- **Hates water**: while its head is underwater it short-circuits and takes damage
- 🏆 **"Oh that just fish"** — sink a tripod somehow (push it into deep water,
  dig the ground under it, whatever works) and you get a challenge advancement
  with 100 XP. Anyone who helped lands it too.

### Woodcrawler («Вудкраулер»)
A tall, thin wooden stalker from *Gemini Home Entertainment*. It is silent —
you hear it only when it is too late.

- 45 HP, fast, attacks in melee
- **On hit it infects you with the Root Virus** (also from the same horror
  universe): periodic damage, slowness and a heartbeat sound while spores pour
  out of you. Cured with milk.
- 🏆 **"The Roots Are Inside You"** — get infected
- Spawns at night in forests and taigas; tripods spawn rarely anywhere in the
  Overworld

Both mobs have spawn eggs (creative tab "Spawn Eggs") and can be tuned via
`config/randommobs-common.toml`.

## Building

Requires JDK 17.

```bash
./gradlew build          # jar in build/libs/
./gradlew runClient      # test in game
python3 tools/check_setup.py   # offline sanity checks (no Java needed)
python3 tools/gen_textures.py  # regenerate the pixel-art textures
```

> Note: this sandbox has no outbound access to Minecraft/Forge maven servers,
> so `./gradlew build` was not executed here. The Java sources were verified
> with a full offline compile against API stubs (`tools/apistubs`), and all
> resources are validated by `tools/check_setup.py`.

## Structure

```
src/main/java/com/randommobs/
├── RandomMobs.java          # main mod class + client setup
├── RandomMobsConfig.java    # common config (damage, virus duration...)
├── entity/                  # TripodEntity, WoodcrawlerEntity
├── effect/                  # RootVirusEffect
├── registry/                # entities, items, effects, advancements helpers
├── setup/                   # spawn placements
└── client/                  # models + renderers
```

## License

MIT
