package repository;

import com.example.demo.models.Vopros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoprosRepository extends JpaRepository<Vopros,Integer> {
}
