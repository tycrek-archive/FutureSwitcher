# FutureSwitcher
Profile switching tool for Future Client

### How to use

1. Install Java (project is built and tested with Java 8 but should work fine with later versions)
2. Download the latest `.jar` from [Releases](https://github.com/tycrek/FutureSwitcher/releases/)
3. Set up your Future profiles (see below)
4. Run the `.jar` file by double-clicking it
5. Click the **Import** button to import your Future profiles
6. Click on any Future profile to load it
7. If it was successful, type `.reload` in Minecraft chat to load the profile

### Setting up Future profiles

1. Future configs are stored in your user folder. On Windows this is usually `C:\Users\YourUsername`
2. Do steps 3-5 to build your profiles
3. In Minecraft, build your desired config using the Future GUI and commands
4. When you are done, type `.save` into chat
5. In your user profile, **copy** the folder `Future/` and rename the new one to what the profile is for, e.x. `Future PVP/`


### Tips

- This tool should work fine with regular Future and Forge. It might not work with MultiMC, but I don't use that, so I can't test it.
- If you make changes in-game and want to switch profiles, make sure you set up a profile if you want to keep these changes. FutureSwitcher **will overwrite** anything in `Future/`!

### FAQ
- **Is this a backdoor?** No. If you don't believe me you can look at the two `.java` files and see there is no networking whatsoever.
- **Will it erase my current config?** Yeah, that's kind of the point; it has to import the other settings somehow.
- **The code is shit.** First of all that's not a question and second of all I know it is, I made this in 30 minutes
- **It broke my game :(** oof.

### Special thanks

- Rob Camick for making [WrapLayout](https://tips4java.wordpress.com/2008/11/06/wrap-layout/)
- All the users in the Future Client Discord for wanting a profile system