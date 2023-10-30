

#**Android Shopping Cart Application**

This repository contains the source code for an Android shopping cart application. The app allows users to add items to their shopping cart, view and manage their cart, and change the app's background color.

**Key Components:**

1. **MainActivity**: The main activity of the app where users can navigate between the home screen and settings screen. The background color can be changed from the settings screen.

2. **HomeFragment**: Displays the home screen with a simple logo and a button that displays a toast message when clicked.

3. **SettingsFragment**: Allows users to change the background color of the app using a spinner and save their preferences.

4. **CartFragment**: Manages the shopping cart, allowing users to add items, view their cart, and delete items. Uses a RecyclerView to display the cart items.

5. **CartAdapter**: An adapter for the RecyclerView in the CartFragment. It displays cart items and handles item deletion.

6. **CartViewHolder**: Holds the view for individual cart items in the RecyclerView.

7. **CartDatabase**: Manages the local SQLite database for storing cart items.

8. **CartRepository**: Acts as an intermediary between the database and the ViewModel.

9. **MainActivityData**: A ViewModel class that communicates data between fragments and the main activity, ensuring data consistency.

10. **FragmentViewModel**: Manages the background color state across fragments.

**Features:**

- Add items to the shopping cart.
- View and manage the shopping cart.
- Change the background color of the app.

This Android shopping cart application serves as a useful reference for implementing RecyclerViews, fragment navigation, and data management in Android apps.

