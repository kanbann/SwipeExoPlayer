# 📽️ Vertical Swipe Video Player (Android)

A high-performance Android app that implements a **vertical swipe video player** similar to Facebook Reels using **ViewPager2, ExoPlayer (Media3), and ViewModel** for seamless playback state retention.  

## 🎯 Features
✅ **ViewPager2 + FragmentStateAdapter** → Smooth vertical swipe experience  
✅ **ExoPlayer (Media3)** → High-performance video playback  
✅ **ViewModel for Playback State** → Resumes video when swiping back  
✅ **Efficient Memory Management** → Only one ExoPlayer runs at a time  
✅ **Optimized Performance** → Prevents memory leaks and excessive player instances  

## 🚀 Tech Stack
- **Kotlin**  
- **ViewPager2** (for swipe functionality)  
- **ExoPlayer (Media3)** (for video playback)  
- **ViewModel** (for retaining playback state)  

## 📂 Project Structure
```
📂 app
 ┣ 📜 MainActivity.kt  → Sets up ViewPager2  
 ┣ 📜 FragmentVideo.kt  → Handles ExoPlayer instance per page  
 ┣ 📜 PagerAdapterVideo.kt  → Adapter for ViewPager2  
 ┣ 📜 ViewModelMain.kt  → Stores playback positions  
 ┣ 📜 ViewModelVideo.kt  → Handle Exoplayer

```

## 📸 Screenshots
| Scrolling Experience | Video Playback |
|----------------------|---------------|
| ![Video Screenshot](https://github.com/user-attachments/assets/590199d7-c38a-4a71-aa66-7e6d26dd941c) | ![Playback](https://github.com/user-attachments/assets/f5f584d1-24a5-4a15-9d1d-f17a747f6c17) |


## 🔧 Setup & Installation
1. **Clone the repo**  
   ```sh
   git clone https://github.com/epegasus/SwipeExoPlayer.git
   ```
2. **Open in Android Studio**  
3. **Run the project** on an emulator or device  

## 🛠️ How It Works
- The **ViewPager2** loads `VideoFragment` for each video.  
- Each fragment initializes **ExoPlayer** in `onViewCreated()`.  
- The **ViewModel stores playback position** and restores it when swiping back.  
- The app ensures **only one ExoPlayer instance plays at a time** to optimize memory usage.  

## 🙌 Contributions
Feel free to **fork, improve, and submit PRs** to enhance this project!  

## 📜 License
This project is licensed under the **MIT License**.

