package edu.iu.c490.synonymist

import java.util.*

//Data class to hold information for Statistics view.
data class Statistics(val id: UUID = UUID.randomUUID(),
                      var numeratorFractionStat: Int = 0,
                      var denominatorFractionStat: Int = 0
                      //do I need percentageStat that divides numerator/denominator?  I can just divide the two potentially
                      )