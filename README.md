# GameplayEssentials StationAPI Edition for Minecraft Beta 1.7.3

A StationAPI mod for Minecraft Beta 1.7.3 that fixes gameplay bugs and adds a few gameplay features.
* Mod now works on Multiplayer with [GlassConfigAPI](https://modrinth.com/mod/glass-config-api) version 2.0+ used to sync configs!

## Gameplay Bugfixes

* Fix bucket being consumed when lava bucket is used in furnace
* Fix slimes not dropping slimeballs when an attack brings them below zero health
* Fix minecarts stopping on items/arrows
* Fix mobs jittering in multiplayer
* Fix fish flying above player head (default: false)
    * Default false because during multiplayer testing it was found that vanilla behavior is more correct

## Gameplay Features

* Change bed behavior: vanilla, disable nightmares, set spawn-point only, or disable entirely
* Allow disabling block interactions with a keybind (thereby allowing things like placing torches on crafting tables)
* Allow disabling eating when at max health (default: false)
* Allow pressure plates to be placed on fences
* Allow sugar cane to be placed on sand
* Allow trapdoors to be placed without support
* Change jack-o'-lantern recipe to be shapeless
* Change stairs recipe output (output: 1-16, default: 4)
* Add ability to equip/swap pieces of armor with `right-click`

## Installation using Prism Launcher

1. Download an instance of Babric for Prism Launcher: https://github.com/babric/prism-instance
2. Install Java 17, set the instance to use it, and disable compatibility checks on the instance: https://adoptium.net/temurin/releases/
3. Add StationAPI to the mod folder for the instance: https://modrinth.com/mod/stationapi
4. (Optional) Add Mod Menu to the mod folder for the instance: https://modrinth.com/mod/modmenu-beta
5. (Optional) Add GlassConfigAPI 3.0+ to the mod folder for the instance: https://modrinth.com/mod/glass-config-api
6. Add this mod to the mod folder for the instance: https://github.com/telvarost/GameplayEssentials-StationAPI/releases
7. Run and enjoy! 👍

## Feedback

Got any suggestions on what should be added next? Feel free to share it by [creating an issue](https://github.com/telvarost/GameplayEssentials-StationAPI/issues/new). Know how to code and want to do it yourself? Then look below on how to get started.

## Contributing

Thanks for considering contributing! To get started fork this repository, make your changes, and create a PR. 

If you are new to StationAPI consider watching the following videos on Babric/StationAPI Minecraft modding: https://www.youtube.com/watch?v=9-sVGjnGJ5s&list=PLa2JWzyvH63wGcj5-i0P12VkJG7PDyo9T
