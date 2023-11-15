import pandas as pd
import matplotlib.pyplot as plt


def plot_two_csv_files(file1_path, file2_path):
    # Read CSV files using pandas
    data1 = pd.read_csv(file1_path)
    data2 = pd.read_csv(file2_path)

    # Extracting both the number of elements and the time data from the pandas dataframes.
    x_data1, y_data1 = data1['Number of elements'], data1['Time']
    x_data2, y_data2 = data2['Number of elements'], data2['Time']

    # Plotting the data from the MergeSort file onto the graph.
    plt.plot(x_data1, y_data1, label='Merge Sort', marker='', linestyle='-')

    # Plotting the data from the SelectionSort file onto the graph.
    plt.plot(x_data2, y_data2, label='Selection Sort', marker='', linestyle='-')

    # Setting labels and title of the graph.
    plt.title('Comparison of Sorting algorithms')
    plt.xlabel('Number of Elements')
    plt.ylabel('Time (ns)')

    plt.legend()
    plt.show()


# Main code execution point.
if __name__ == "__main__":
    file1_path = '../../MergeSort.csv'
    file2_path = '../../SelectionSort.csv'

    plot_two_csv_files(file1_path, file2_path)
