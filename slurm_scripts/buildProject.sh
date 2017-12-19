#!/bin/bash

#SBATCH --time=00:10:00
#SBATCH -N 1
#SBATCH --mem=2000

module load openmpi-2.1.0
module load gradle/4.4

echo "modules loaded"
cd ../benchmarkingalgorithms
echo "starting build"
gradle build
