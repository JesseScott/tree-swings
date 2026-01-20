package tt.co.jesses.treeswings.data.repository

import tt.co.jesses.treeswings.data.model.TreeSwing

interface TreeSwingsRepository {
    suspend fun getSwings(): List<TreeSwing>
}

class TreeSwingsRepositoryImpl : TreeSwingsRepository {
    override suspend fun getSwings(): List<TreeSwing> {
        return listOf(
            TreeSwing("1", "Oak Tree Swing"),
            TreeSwing("2", "Backyard Tire Swing"),
            TreeSwing("3", "Park Bench Swing"),
            TreeSwing("4", "River Rope Swing")
        )
    }
}
