import pandas as pd
import matplotlib.pyplot as plt

def plot_two_csv_files(file1_path, file2_path):
    # Read CSV files into pandas DataFrames
    df1 = pd.read_csv(file1_path)
    df2 = pd.read_csv(file2_path)

    # Extract x and y data from the DataFrames
    x_data1, y_data1 = df1['Number of elements'], df1['Time']
    x_data2, y_data2 = df2['Number of elements'], df2['Time']

    # Plot the data from the first CSV file
    plt.plot(x_data1, y_data1, label='Merge Sort', marker='', linestyle='-')

    # Plot the data from the second CSV file
    plt.plot(x_data2, y_data2, label='Selection Sort', marker='', linestyle='-')


    # Set labels and title
    plt.title('Comparison of Sorting algorithms')
    plt.xlabel('Number of Elements')
    plt.ylabel('Time (ns)')

    # Show legend
    plt.legend()

    # Show the plot
    plt.show()


if __name__ == "__main__":
    # Provide the paths to your CSV files
    file1_path = '../../MergeSort.csv'
    file2_path = '../../SelectionSort.csv'

    # Update column names based on your CSV files
    plot_two_csv_files(file1_path, file2_path)
