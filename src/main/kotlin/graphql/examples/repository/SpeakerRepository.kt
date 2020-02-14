package graphql.examples.repository

import graphql.examples.pojo.Speaker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpeakerRepository : JpaRepository<Speaker, Long>
