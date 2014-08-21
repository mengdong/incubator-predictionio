package io.prediction.engines.itemrank

import io.prediction.controller.IEngineFactory
import io.prediction.controller.Engine

object ItemRankEngine extends IEngineFactory {
  def apply() = {
    new Engine(
      classOf[ItemRankDataSource],
      classOf[ItemRankPreparator],
      Map("knn" -> classOf[KNNAlgorithm],
        "rand" -> classOf[RandomAlgorithm],
        "mahout" -> classOf[MahoutItemBasedAlgorithm],
        "legacy" -> classOf[legacy.LegacyAlgorithm]),
      classOf[ItemRankServing]
    )
  }
}