# Ervin Modja - Minecraft Forge Mod

A simple Minecraft Forge mod that adds craftable charcoal blocks to the game.

## Features

- Compressed charcoal blocks
- Decorative building options
- Efficient fuel storage

## Version Support

This mod supports multiple Minecraft versions:
- 1.16.5
- 1.17.1
- 1.18.2
- 1.19.4
- 1.20.1

## How to Update the Mod to a Different Minecraft Version

This repository includes an `UPDATE_GUIDE.md` file that provides detailed instructions for updating the mod to different Minecraft versions.

### Quick Steps to Update

1. Backup your mod project before making any changes
2. Open the `UPDATE_GUIDE.md` file and find the section for your target Minecraft version
3. Update the `gradle.properties` file with the values provided in the guide
4. Update the `pack.mcmeta` file with the correct pack_format value
5. Make any necessary code changes based on API differences (if any)
6. Run `./gradlew clean build` to build the mod for the new version
7. Test the mod thoroughly in the new Minecraft version

### Example: Updating to Minecraft 1.18.2

The following files were modified to update from 1.17.1 to 1.18.2:

1. `gradle.properties`:
   - Changed `minecraft_version` to 1.18.2
   - Changed `minecraft_version_range` to [1.18.2,1.19)
   - Changed `forge_version` to 40.2.0
   - Changed `forge_version_range` to [40,)
   - Changed `loader_version_range` to [40,)
   - Changed `mapping_version` to 1.18.2
   - Changed `mod_version` to reflect the new Minecraft version

2. `pack.mcmeta`:
   - Changed `pack_format` to 8

No code changes were required for this update as the API remained compatible.

## License

All Rights Reserved