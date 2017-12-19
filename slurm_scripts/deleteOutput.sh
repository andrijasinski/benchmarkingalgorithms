#!/bin/bash

#SBATCH --time=00:10:00
#SBATCH -N 1
#SBATCH --mem=2000


find . -name "*.out" -type f -delete

