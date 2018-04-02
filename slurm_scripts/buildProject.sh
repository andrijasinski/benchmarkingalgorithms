#!/bin/bash

#SBATCH --time=00:10:00
#SBATCH -N 2
#SBATCH --mem=2000

N=2

module load openmpi-2.1.0
module load gradle/4.4

echo "modules loaded"
echo "NUMBER OF NODES = ${N}"
cd ../benchmarkingalgorithms
echo "starting build"
gradle build
