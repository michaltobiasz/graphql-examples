package graphql.examples.repository

import graphql.examples.pojo.Talk
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TalkRepository : JpaRepository<Talk, Long>
