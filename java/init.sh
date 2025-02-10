#!/bin/bash

# Prompt the user for the directory name
read -p "Enter the directory name: " dir_name

# Create the directory with the provided name
mkdir -p "$dir_name"

# Define the paths for Main.java and Solution.java
main_file="$dir_name/Main.java"
solution_file="$dir_name/Solution.java"

# Create the Solution.java file
cat <<EOL > "$solution_file"
public class Solution {
    public String getMessage() {
        return "Hello from Solution class!";
    }
}
EOL

# Create the Main.java file and call Solution class
cat <<EOL > "$main_file"
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMessage());
    }
}
EOL

# Provide feedback to the user
echo "Directory '$dir_name' created with 'Main.java' and 'Solution.java' files."
