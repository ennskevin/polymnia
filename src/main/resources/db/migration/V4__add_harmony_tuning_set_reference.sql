ALTER TABLE harmonies
ADD CONSTRAINT fk_harmonies_source_tuning_set
    FOREIGN KEY (source_tuning_set_id)
    REFERENCES tuning_sets(id)
    ON DELETE SET NULL;