package org.example.nguyenvanhuytest.service;

import org.example.nguyenvanhuytest.entity.Indexer;
import org.example.nguyenvanhuytest.entity.Player;
import org.example.nguyenvanhuytest.entity.PlayerIndex;
import org.example.nguyenvanhuytest.repository.PlayerIndexRepository;
import org.example.nguyenvanhuytest.repository.impl.PlayerIndexRepositoryImpl;

import java.util.List;

public class PlayerIndexService {

    private final PlayerIndexRepository playerIndexRepository;

    public PlayerIndexService() {
        this.playerIndexRepository = new PlayerIndexRepositoryImpl();
    }

    public List<PlayerIndex> getAll() throws Exception {
        return playerIndexRepository.findAll();
    }

    public PlayerIndex getPlayerIndexByPlayerAndIndexer(Player player, Indexer indexer){
        return playerIndexRepository.getPlayerIndexByPlayerAndIndexer(player, indexer);
    }

    public PlayerIndex getPlayerById(int id) throws Exception {
        PlayerIndex playerIndex = playerIndexRepository.findById(id);
        if(playerIndex == null){
            throw new Exception("PlayerIndex not found!");
        }
        return playerIndex;
    }

    public void savePlayerIndex(PlayerIndex playerIndex){
        playerIndexRepository.save(playerIndex);
    }

}
