class Firstfit
{// Function to implement First Fit allocation scheme
    static void Firstfit(int blockSize[], int p,
       int processSize[], int s){

// Code to store the block id for block allocation
       int allocate[] = new int[s];

// No block assigned at program initiation
      for (int i = 0; i < allocate.length; i++)
        allocate[i] = -1;// allocation of block j to p[i] process

// Pick every process and look for a suitable block
      for (int i = 0; i < s; i++){
      for (int j = 0; j < p; j++){
           if (blockSize[j] >= processSize[i]){     
                allocate[i] = j;

// Available memory in the block is reduced
      blockSize[j] -= processSize[i];
      break;
    }
  }
}
      System.out.println("\nProcess Number\tProcess Size\tBlock Number.");
            for (int i = 0; i < s; i++){
              System.out.print(" " + (i+1) + "\t\t" +processSize[i] + "\t\t");

                if (allocate[i] != -1)
                  System.out.print(allocate[i] + 1);
                else
                  System.out.print("Not Allocated");
                  
                  System.out.println();
                  }

}
