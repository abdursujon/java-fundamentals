FileWriter writes directly to disk every time — slow for large files.
BufferedWriter stores writes in memory first, then flushes to disk in one go — much faster when writing a lot of data.