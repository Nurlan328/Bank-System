package kz.iitu.itse1910.nurlan.oibekuly.repository.pagination;

import kz.iitu.itse1910.nurlan.oibekuly.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends PagingAndSortingRepository<Users, Integer> {
}