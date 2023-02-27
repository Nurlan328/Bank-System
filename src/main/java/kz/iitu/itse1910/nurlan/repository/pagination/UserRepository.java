package kz.iitu.itse1910.nurlan.repository.pagination;

import kz.iitu.itse1910.nurlan.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends PagingAndSortingRepository<Users, Integer> {
}
