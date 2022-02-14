# OnePlus Custom Wallpaper Provider

A way to get custom (animated) wallpapers on OnePlus phones.

A sample wallpaper is provided for testing purposes.

Tested on my OnePlus 6T running OxygenOS 11.

## Adding a wallpaper

There are two different kinds of wallpaper supported by this app, animated and static.\
Adding an animated wallpaper involves adding a static one, so I'll be focusing on this.

1. Create your animated wallpaper.\
   This can be done in any program that spits out an mp4 file by the end.\
   (Other formats may work but I haven't tested them)

2. Place you video file on [app/src/main/assets](/app/src/main/assets).

3. Place images containing the first and last frames of the video on
   [app/src/main/res/drawable-nodpi](/app/src/main/res/drawable-nodpi).

4. Add an entry to [app/src/main/res/raw/config.json](/app/src/main/res/raw/config.json) with your file names:

   ```json
   {
      "image_res_name": "net.oneplus.wallpaperresources:drawable/<last_frame>",
      "fod_video_file_name" : "<video>.mp4",
      "fod_video_first_frame" : "net.oneplus.wallpaperresources:drawable/<first_frame>"
   }
   ```

5. Compile your app!

The included config.json has entries for a static and an animated background, in case you get lost.
