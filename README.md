🅰️ ASCII Art Generator (Java Project)

This is a simple Java-based console project developed as part of my Bachelor of Computer Applications (BCA) coursework.
The project displays ASCII art representations of alphabets, numbers, and special symbols using only core Java programming.

It provides a menu-driven text interface for users to explore letters, words, ranges, numbers, and symbols in ASCII art form.

🚀 Features

🎨 Display single letters, words, or alphabet ranges in ASCII art

🔢 Generate ASCII representations of numbers (0–9)

💠 View a set of special symbols like !, @, #, ?, etc.

🧭 Menu-driven interface for simple console interaction

🧩 Modular structure — easy to extend with more ASCII data

🧠 Built entirely with Core Java (no external libraries required)

🛠️ Technologies Used

Java SE (Standard Edition)

Java Utility Package (java.util)

Console I/O (Scanner for user input)

Any IDE — Eclipse, IntelliJ IDEA, NetBeans, or VS Code

📁 Project Structure
Java-Ascii-Art/
├── src/
│   ├── Ascii.java
├── README.md

📖 How It Works

The user runs the program from the console.

A simple menu appears with options:

1. Show Letter      2. Show Word
3. Show Range       4. Show Numbers
5. Show Symbol      0. Exit


Based on the selection:

The program prints ASCII versions of characters, words, or ranges.

ASCII data is stored in 2D string arrays (LETTERS, NUMBERS, SYMBOLS).

It uses string slicing and indexing logic to extract the desired pattern.
